#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/21 13:49

# 古诗文网登录

import json
import requests
from bs4 import BeautifulSoup
import urllib.request

url = 'https://so.gushiwen.cn/user/login.aspx?from=http://so.gushiwen.cn/user/collect.aspx'
# url = 'https://so.gushiwen.cn/user/login.aspx'
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36'
}

# 获取网页源码
resp = requests.get(url, headers=headers)
content = resp.text

# 获取 __VIEWSTATE, __VIEWSTATEGENERATOR
soup = BeautifulSoup(content, 'lxml')
# select 返回 list
__VIEWSTATE = soup.select('#__VIEWSTATE')[0].attrs.get('value')
__VIEWSTATEGENERATOR = soup.select('#__VIEWSTATEGENERATOR')[0].attrs.get('value')

# 获取验证码图片
code = soup.select('#imgCode')[0].attrs.get('src')
code_url = 'https://so.gushiwen.cn' + code
# urllib.request.urlretrieve(code_url, 'code.jpg')

# 使用 session, 使请求验证码和提交post是同一请求
session = requests.session()
resp_code = session.get(code_url)
content_code = resp_code.content
with open('code.jpg', 'wb') as f:
    f.write(content_code)

code_name = input('plz input code: ')
data_post = {
    '__VIEWSTATE': __VIEWSTATE,
    '__VIEWSTATEGENERATOR': __VIEWSTATEGENERATOR,
    'from': 'http://so.gushiwen.cn/user/collect.aspx',
    'email': 'rahratch@foxmail.com',
    'pwd': 'uiWhVkjWWRm68J3',
    'code': code_name,
    'denglu': '登录'
}
resp_post = session.post(url, data_post, headers=headers)
content_post = resp_post.text
with open('logged.html', 'w', encoding='utf-8') as f:
    f.write(content_post)
