### SpringMVC

- DispatcherSevlet
  - Controller
  - xxxResolver
    - ViewResolver
    - HandlerExceptionResolver
    - MultipartResolver
  - HandlerMapping

### Spring的应用程序上下文

- ##### 关于上下文常用的接口及其实现

  - BeanFactory
    - DefaultListableBeanFactory
  - ApplicationContext
    - ClassPathXmlApplicationContext
    - FileSystemXmlApplicationContext
    - AnnotationConfigApplicationContext
  - WebApplicationContext

- ##### 上下文的继承

  - Root WebApplicationContext
  - Servlet WebApplicationContext

### SpringMVC的请求处理流程

- #### 一个请求的大致处理流程

  - ##### 绑定一些Attribute

    - WebApplicationContext/LocaleResolver/ThemeResolver

  - ##### 处理Multipart

    - 如果是则将请求转为MultiPartServletRequest

  - ##### Handler处理

    - 如果找到对应Handler,执行Controller及前后置处理器逻辑

  - ##### 处理返回的Model，呈现视图

### 视图解析的实现基础

- ViewResolver与View接口
  - AbstractCachingViewResolver
  - UrlBasedViewResolver
  - FreeMarkerViewResolver
  - ContentNegotiatingViewResolver
  - InternalResourceViewResolver

### SpringMVC异常处理

- ExceptionHandler
- ControllerAdvice/RestControllerAdvice

### SpringMVC拦截器

- #### HandlerInteceptor

  - boolean preHandler()
  - void psotHandler()
  - void afterCompletion()

### RestTemplate