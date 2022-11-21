#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/15 19:11

# 解析, xpath, 下载站长之家图片

import urllib.request

from lxml import etree

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36',
}


def create_request(page):
    if page == 1:
        url = 'https://sc.chinaz.com/tupian/'
    else:
        # url = 'https://sc.chinaz.com/tupian/index_' + page + '.html'
        url = f'https://sc.chinaz.com/tupian/index_{page}.html'

    req = urllib.request.Request(url=url, headers=headers)
    return req


def def_content(req):
    resp = urllib.request.urlopen(req)
    content = resp.read().decode('utf-8')
    return content


def download(content):
    tree = etree.HTML(content)
    imgNames = tree.xpath('//div[@id="container"]//div/a/img/@alt')
    imgUrls = tree.xpath('//div[@id="container"]//div/a/img/@src2')
    for i in range(len(imgNames)):
        url = 'https:' + imgUrls[i]
        name = imgNames[i]
        urllib.request.urlretrieve(url=url, filename='resource/img/' + name + '.jpg')


if __name__ == '__main__':
    for page in range(1, 2):
        # 定制请求对象
        req = create_request(page)
        # 获取网页源码
        content = def_content(req)
        # 下载
        download(content)
