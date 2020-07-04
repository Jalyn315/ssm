package cn.jalyn.config;

import cn.jalyn.exception.SysException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionHandler implements HandlerExceptionResolver {
    /**
     * 处理异常
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        SysException ex = null;
        if (e instanceof SysException){
            ex = (SysException) e; //强转
        }else {
            ex = new SysException("系统正在维护","555");
        }
        mv.addObject("errorMsg", ex.getMessage()); //获取异常信息
        mv.addObject("errorCode", ex.getCode());
//        判断是客户端异常还是服务器异常
        if (ex.getCode().substring(0,1) == "4"){   //客户端异常  转调4xx页面
            mv.setViewName("../error/4xx");
        }
        if (ex.getCode().substring(0,1) == "5"){ //服务器异常 转调5xx页面
            mv.setViewName("../error/5xx");
        }
        return mv;
    }
}
