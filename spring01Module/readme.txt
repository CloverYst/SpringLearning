spring01Module:这是第一个Spring项目

使用spring：Spring作为容器管理对象，开发人员从Spring中获取要使用的对象

实现步骤：
1.新建一个maven项目

2.加入依赖，修改pom.xml: spring-context(spring的基础依赖) junit(单元测试)

3.开发人员定义类：接口和实现类(类也可以没有接口)
用户--界面层--业务逻辑层(service)--数据访问层--数据库 （三层）

4.创建Spring的配置文件 作用：声明对象，然后才能交给Spring来创建管理对象
使用<bean>标签来声明对象，一个bean表示一个java对象

5.使用容器中的对象：
  创建一个表示Spring容器的对象 ApplicationContext
  从容器中，根据名称获取对象，使用getBean("对象名称")