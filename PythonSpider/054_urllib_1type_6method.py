#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# 一个类型和六个方法

import urllib.request

# 定义 url
url = 'http://www.baidu.com'

# 模拟浏览器向服务器发送请求
resp = urllib.request.urlopen(url)

# 一个类型和六个方法

# <class 'http.client.HTTPResponse'>
# print(type(resp))

# 一个字节一个字节读取
# content = resp.read()
# print(content)

# 读取多少字节
# content = resp.read(5) # b'<!DOC'
# print(content)

# 按行读取
# content = resp.readline()
# print(content)

# 读取多行
# content = resp.readlines()
# print(content)

# 状态码
# print(resp.getcode())

# url
# print(resp.geturl())

# headers
print(resp.getheaders())