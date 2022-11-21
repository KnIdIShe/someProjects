#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# TCP编程

# 导入socket库:
import socket

# 创建一个socket:
# s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# 新浪强制HTTPS协议访问 所以 80端口改443 socket 改 ssl
import ssl

s = ssl.wrap_socket(socket.socket())
# 建立连接:
s.connect(('www.sina.com.cn', 443))
# 向服务器发送请求
s.send(b'GET / HTTP/1.1\r\nHost: www.sina.com.cn\r\nConnection: close\r\n\r\n')
# 接收数据:
buffer = []
while True:
    # 每次最多接收1k字节:
    d = s.recv(1024)
    if d:
        buffer.append(d)
    else:
        break

data = b''.join(buffer)

# 关闭连接:
s.close()

# 分离HTTP头和网页
header, html = data.split(b'\r\n\r\n', 1)
print(header.decode('utf-8'))
# 把接收的数据写入文件:
with open('sina.html', 'wb') as f:
    f.write(html)
