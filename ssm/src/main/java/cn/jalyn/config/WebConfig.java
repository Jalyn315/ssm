package cn.jalyn.config;

import cn.jalyn.exception.SysException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class WebConfig {

//    配置异常处理器，将bean对象加入到容器中，下面两种方法都可以。建议第二种更直观。

//    @Bean
//    public ExceptionHandler CreateExceptionHandler(){
//       return new ExceptionHandler();
//    }

    @Bean
    public HandlerExceptionResolver createHandlerExceptionResolver(){
        return new HandlerExceptionResolver() {
            @Override
            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
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
                    mv.setViewName("4xx");
                }
                if (ex.getCode().substring(0,1) == "5"){ //服务器异常 转调5xx页面
                    mv.setViewName("5xx");
                }
                return mv;
            }
        };
    }
}
