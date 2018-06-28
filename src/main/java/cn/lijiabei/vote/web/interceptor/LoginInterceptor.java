package cn.lijiabei.vote.web.interceptor;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.lijiabei.vote.biz.service.AuthService;
import cn.lijiabei.vote.web.annotation.LoginAnnotation;

/**
 * @ClassName: LoginInterceptor
 * @Description: 后台登陆拦截器
 * @author lijiabei
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private AuthService authService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		LoginAnnotation adminLogin = null;
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Annotation[] classAnnotations = handlerMethod.getBean().getClass().getDeclaredAnnotations();
		for (Annotation annotation : classAnnotations) {
			if (annotation instanceof LoginAnnotation) {
				adminLogin = (LoginAnnotation) annotation;
			}
		}
		if (null != handlerMethod.getMethodAnnotation(LoginAnnotation.class)) {// 方法上的权重最大
			adminLogin = handlerMethod.getMethodAnnotation(LoginAnnotation.class);
		}
		if (null == adminLogin) {
			return true;// 没有标记就放行了吧
		}

		HttpSession session = request.getSession();
		Object object = session.getAttribute("voteUser");
		/**
		 * if(null==object){ VoteUserDO voteUserDO =new VoteUserDO(); voteUserDO.setId(1L); session.setAttribute("voteUser", voteUserDO); return true; }
		 **/

		// 获得回调地址
		String uri = request.getServletPath();
		String queryString = request.getQueryString();

		if (null == object) {
			// 授权重定向
			response.sendRedirect(authService.queryAuthBaseUrl(uri + "?" + queryString));
			return false;// 拦截器拦截结束
		}

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

}
