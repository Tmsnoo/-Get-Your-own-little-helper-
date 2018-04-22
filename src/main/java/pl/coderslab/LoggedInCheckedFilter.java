package pl.coderslab;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

import pl.coderslab.Entity.User;

// @WebFilter registers filter immediately without any other configuration
@WebFilter(description = "Check if user is logged in and if not then redirect", urlPatterns = { "/*" })
public class LoggedInCheckedFilter //extends OncePerRequestFilter {
{}

//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//
//		final HttpServletRequest req = (HttpServletRequest) request;
//		final String url = req.getRequestURL().toString();
//
//		if (allowedToEveryone(url)) {
//			filterChain.doFilter(request, response);
//			return;
//		}
//
//		HttpSession sess = req.getSession();
//		User user = (User) sess.getAttribute("loggedUser");
//
//		if (user == null) {
//			HttpServletResponse httpResponse = (HttpServletResponse) response;
//			httpResponse.sendRedirect(req.getContextPath() + "/user/login");
//			return;
//		}
//
//		filterChain.doFilter(request, response);
//	}
//
//	private boolean allowedToEveryone(final String url) {
//		if (url.endsWith("/user/register") || url.endsWith("/user/login")) {
//			return true;
//		}
//
//		return false;
//	}
//}
