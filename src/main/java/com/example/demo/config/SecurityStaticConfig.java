package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/****
 *
 * @EnableGlobalMethodSecurity
 *  作用：启用方法级别的角色认证
 *  参数: ( prePostEnabled=true ) => 表示可以使用 ( @PreAuthorize ) 注解 和 ( @PostAuthorize )
 *
 * **/
@Configuration
@EnableWebSecurity // 启动 spring-security 安全框架
@EnableGlobalMethodSecurity(prePostEnabled = true) // 启用方法级别的角色认证
class SecurityStaticConfig extends WebSecurityConfigurerAdapter { // WebSecurityConfigurerAdapter 用来控制安全管理的内容

//    @Bean // @Bean将该对象放入容器中
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


    // 自定义认证配置
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder pe = passwordEncoder(); // 调用下面定义的方法，返回PasswordEncoder类型
//        auth.inMemoryAuthentication()
//                .withUser("admin") // 用户名
//                .password(pe.encode("admin")) // 密码，加密
//                .roles("admin") // 角色
//                .and()
//                .withUser("guest")
//                .password("guest")
//                .roles("guest");
//    }

    // 除了上面的方法可以设置用户名和密码外，还可以用下面的方式
    // - 通过重写 ( userDetailsService ) 方法实现
//    protected UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("admin2").password("admin2").roles("admin").build());
//        return manager;
//    }


//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        // 让 spring-security 放行 js css images 文件，不进行拦截
//        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
//    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/security-admin/**").hasAnyRole("admin") //《》这个controller需要 admin 角色
//                .antMatchers("/security-guest/**").hasAnyRole("guest") //《》这个controller需要 guest 角色
//                .anyRequest().authenticated() // 表示除了上面两个是 ( 角色级别的认证 ) 外，其他所有请求都要 ( 认证级别 ) 后才能访问，即只有上面两个需要登陆和对应的角色，其他都只需要登陆
//                .and()
//                .formLogin() //----------------------------------【】
//                //   .loginPage("/login.html") // ---------------【】登陆页面 ( 如果不设置下面的loginProcessingUrl =>  登陆页面 和 登陆接口 都是 login )
//                .loginProcessingUrl("/doLogin")
//                //   .loginProcessingUrl("/security-test") //----【】提交username和password的url
//                //   .usernameParameter("username") // ----------【】自定义html表单中的input的name属性
//                //   .passwordParameter("password") // ----------【】自定义html表单中的input的name属性
//                //   .successForwardUrl("/musics") // -----------【】【服务端跳转】登陆成功的跳转地址，不管是从什么地方跳转到登陆页面的，登陆成功后，都是跳到这里指定的路由
//                //   .defaultSuccessUrl("/musics") // -----------【】【重定向】登陆成功后，会回到之前的页面
//                .successHandler((req, resp, authentication) -> { // =============== 登陆成功的回调函数
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter writer = resp.getWriter();
//                    writer.write(new ObjectMapper().writeValueAsString(authentication.getPrincipal()));
//                    writer.flush();
//                    writer.close();
//                })
//                .failureHandler((req, resp, exception) -> { // ===================== 登陆失败的回调函数
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter writer = resp.getWriter();
//                    writer.write(new ObjectMapper().writeValueAsString(exception.getMessage()));
//                    writer.flush();
//                    writer.close();
//                })
//                .permitAll() // ----------------------------【】表示：登陆相关的页面都 放行 不拦截
//                // .and()
//                // .logout() // 注销登陆
//                // .logoutUrl("/logout") // 注销登陆的地址
//                // .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "post"))
//                .and()
//                .csrf().disable(); // 关掉csrf
//    }
}
