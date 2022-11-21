#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# UDP编程, server

# 导入socket库:
import socket

# 创建一个socket, SOCK_DGRAM指定了这个Socket的类型是UDP
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# 监听端口:
s.bind(('127.0.0.1', 9999))
print('Bind UDP on 9999...')

# 接受来自客户端的连接
while True:
    # 接收数据
    data, addr = s.recvfrom(1024)
    print('Received from %s:%s' % addr)
    s.sendto(b'Hello, %s!' % data, addr)
