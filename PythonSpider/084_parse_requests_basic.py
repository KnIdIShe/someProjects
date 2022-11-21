#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/21 13:49

#

import requests

url = 'http://www.baidu.com'

resp = requests.get(url)
# 设置响应编码
# resp.encoding = 'utf-8'


# 一个类型, 六个属性

# <class 'requests.models.Response'>
# print(type(resp))

# 网页源码
# print(resp.text)

# 请求的 url
# print(resp.url)

# 响应的 byte数据
# print(resp.content)

# 响应的 状态码
# print(resp.status_code)

# 响应的 响应头
print(resp.headers)