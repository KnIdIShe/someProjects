#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# 使用 urllib 获取百度首页源码

import urllib.request

# 定义 url
url = 'http://www.baidu.com'

# 模拟浏览器向服务器发送请求
resp = urllib.request.urlopen(url)

# 获取响应体, read() 返回为二进制, 解码为utf-8
content = resp.read().decode('utf-8')

# 打印
print(content)
