package com.miaoshaproject.controller;

import com.miaoshaproject.controller.viewobject.UserVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller("user")
@RequestMapping("/user")
@CrossOrigin //To avoid CORS error,because html file and localhost have different origin.
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;
    //it's a proxy. thread local map is used to make different thread operating different requests.


    @RequestMapping(value="/getotp", method={RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name="telephone")String telephone){
        //generating otp code
        Random random = new Random();
        int randomInt = random.nextInt(99999);
        randomInt += 10000;
        String otpCode = String.valueOf(randomInt);

        //store the relation of telephone numebr and otp code in HttpSession
        httpServletRequest.getSession().setAttribute(telephone, otpCode);

        //Send the OTP Code to user
        //This is just for testing. OTP code should not print for real case.
        System.out.println("******Testing: telephone:"+telephone+"&OtpCode:"+otpCode);

        return CommonReturnType.create(null);
    }




    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name="id") Integer id) throws BusinessException {

        UserModel  userModel = userService.getUserById(id);

        if(userModel == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }

        UserVO userVO = convertFromUserModel(userModel);

        return CommonReturnType.create(userVO);
    }

    private UserVO convertFromUserModel(UserModel userModel){
        if(userModel == null)
            return null;
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }


}



