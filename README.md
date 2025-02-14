# dm
本项目实现了java jna框架免注册调用大漠插件。

# 说明
- dm-base 大漠所有基础方法，可单独使用
- dm-common 项目使用的一些常量。
- dm-grpc 远程服务定义。
- run 目录下是可启动的项目，使用jpackage打包成exe。
- run dm-control 中控项目，统一管理终端，实现具体业务逻辑。
- run dm-terminal 终端项目，执行最基础的命令。
终端连接后，会自动下载所有资源文件。


# 中控项目主界面
![image](https://github.com/user-attachments/assets/b0d0f26b-a225-490d-9677-180e1fc01d81)
## 中控操作终端示例窗口
![image](https://github.com/user-attachments/assets/f9ea0381-5ebb-4cd7-8dc4-276f70800a51)

# 终端项目主界面
![image](https://github.com/user-attachments/assets/5dfd5788-d878-4abb-8167-8091c6f9755f)
