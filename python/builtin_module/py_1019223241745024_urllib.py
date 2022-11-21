#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# urllib

# from urllib import request

# get
# with request.urlopen('https://yesno.wtf/api') as f:
# with request.urlopen('https://v1.jinrishici.com/shuqing/daowang') as f:
#     data = f.read()
#     print('Status:', f.status, f.reason)
#     for k, v in f.getheaders():
#         print('%s: %s' % (k, v))
#     print('Data:', data.decode('utf-8'))


# 模拟浏览器发送GET请求
# req = request.Request('http://www.douban.com/')
# req.add_header('User-Agent',
#                'Mozilla/6.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/8.0 Mobile/10A5376e Safari/8536.25')
# with request.urlopen(req) as f:
#     print('Status:', f.status, f.reason)
#     for k, v in f.getheaders():
#         print('%s: %s' % (k, v))
#     print('Data:', f.read().decode('utf-8'))


# post
# from urllib import request, parse
#
# print('Login to weibo.cn...')
# email = input('Email: ')
# passwd = input('password: ')
# login_data = parse.urlencode([
#     ('username', email),
#     ('password', passwd),
#     ('entry', 'mweibo'),
#     ('client_id', ''),
#     ('savestate', '1'),
#     ('ec', ''),
#     ('pagerefer', 'https://passport.weibo.cn/signin/welcome?entry=mweibo&r=http%3A%2F%2Fm.weibo.cn%2F')
# ])
#
# req = request.Request('https://passport.weibo.cn/sso/login')
# req.add_header('Origin', 'https://passport.weibo.cn')
# req.add_header('User-Agent',
#                'Mozilla/6.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/8.0 Mobile/10A5376e Safari/8536.25')
# req.add_header('Referer',
#                'https://passport.weibo.cn/signin/login?entry=mweibo&res=wel&wm=3349&r=http%3A%2F%2Fm.weibo.cn%2F')
#
# with request.urlopen(req, data=login_data.encode('utf-8')) as f:
#     print('Status:', f.status, f.reason)
#     for k, v in f.getheaders():
#         print('%s: %s' % (k, v))
#     print('Data:', f.read().decode('utf-8'))


# test
# 利用urllib读取JSON，然后将JSON解析为Python对象：
import json
from urllib import request


def fetch_data(url):
    with request.urlopen(url) as f:
        data = f.read().decode('utf-8')

    return json.loads(data)


# 测试
# URL = 'https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20%3D%202151330&format=json'
# URL = 'https://yesno.wtf/api'
URL = 'https://v1.jinrishici.com/shuqing/daowang'
data = fetch_data(URL)
print(data)
assert data['category'] == '古诗文-抒情-悼亡'
print('ok')
