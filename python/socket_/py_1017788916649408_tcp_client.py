#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# TCP编程, client

# 导入socket库:
import socket

# 创建一个socket:
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# 建立连接:
s.connect(('127.0.0.1', 9999))
# 接收欢迎消息:
print(s.recv(1024).decode('utf-8'))

for data in [b'Michael', b'Tracy', b'Sarah']:
    # 发送数据:
    s.send(data)
    # 接收数据
    print(s.recv(1024).decode('utf-8'))

# 发送退出消息
s.send(b'exit')

# 关闭连接:
s.close()
