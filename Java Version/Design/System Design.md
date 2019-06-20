---
typora-root-url: ..
---

# System Design

System Design is the process of defining the architecture, modules, interfaces and data for a system to satisfy specified requirements.

## 系统设计要素

- 需求

- 系统

- 设计

   																	Offline Data Pipelines ----------------

  ​																															   |

​                                                                                                                                  Storage

​                                                                                                                                       |

Mobile Client  ------ Internet ------  HTTP Server ----- Application Severs ---------- 



### HTTP Server

HTTP Server支持的操作有： GET, POST, PUT, DELETE

HTTP是应用层协议，所有的Web通讯都是用HTT协议的方式来完成前后端通信的。因此也被沿用的到了Mobile时代

HTTP Sever是用于处理和响应终端的HTTP请求的，然后根据不同请求的需求，分发到相应的Application Server.

URL: host + path

> https://www.oreilly.com/library/view/http-the-definitive/1565925092/ch04s01.html

[http://www.joes-hardware.com:80/power-tools.html](http://www.joes-hardware.com/power-tools.html)

(1) The Browser extracts the hostname

(2) The Browser looks up the IP address for this hostname (DNS)

(3) The Browser gets the port number (80)

(4) The Browser makes a TCP connections to DNS.port

(5) The Browser sends an HTTP **Get** request msg to the server

(6) The Browser reads the HTTP **response** message from the server

(7) The Browser closes the connections



### Application Response

An Application Server is a software framework that provides both facilities to create Web Application and server environment to run them. 也就是具体的业务逻辑

当HTTP Sever搜索到这个请求后，主要去做：

- 判断这个发起者有没有权利这么做
- 根据搜索关键词给出结果
- 广告

这些业务逻辑可以在同一应用服务器重的一整段逻辑去做，也可以在各自的应用服务器完成各自的逻辑。典型的Application Server有：.Net Application Server;  PHP;  Ruby;  Node JS



### Offline Data Pipline

对数据的后台处理，比如 ranking 算法， Search 算法



### Storage

数据库：关系数据库，非关系数据库，SQL



### Internet

网络协议： TCP; IP; HTTP

![sys](C:\Users\Nuo Xu\Desktop\Python-Problems-and-Solutions\Java Version\Design\sys.JPG)





## TCP Reliable Data Pipes

TCP gives HTTP a *reliable bit pipe* . Bytes stuffed in one side of a TCP connection come out the other side correctly, and in the right order





www.yelp.com/search?q=chinese

1. HTTP Request

   发生了POST  URL: HOST + Path

2. TCP connection. SYNC-ACK SYNC-ACK 3 Connections

3. SEND TCP PACKAGE  



Load Balancer



Caches

CPU中有硬件层面的Caches.有Cache的地方写数据的开销都增加了