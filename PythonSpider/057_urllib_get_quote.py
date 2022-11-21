#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/14 10:07

# URL 的编码, 单个参数

import urllib.request
import urllib.parse

# UnicodeEncodeError: 'ascii' codec can't encode characters in position 10-12: ordinal not in range(128)
# url = 'https://www.baidu.com/s?wd=周杰伦'

url = 'https://www.baidu.com/s?wd=%E5%91%A8%E6%9D%B0%E4%BC%A6'
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36'}

# 编码为 Unicode
# URL 的编码与解码可以使用 urllib.request.quote() 与 urllib.request.unquote() 方法
name = urllib.parse.quote('周杰伦')

url = url + name

# 定制请求对象
req = urllib.request.Request(url=url, headers=headers)

resp = urllib.request.urlopen(req)

content = resp.read().decode('utf-8')
print(content)
