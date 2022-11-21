#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/14 10:47

# get 获取kfc餐厅列表

import urllib.parse
import urllib.request


def create_request(pageNum):
    baseUrl = 'http://www.kfc.com.cn/kfccda/ashx/GetStoreList.ashx?op=cname'
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36',
    }
    data = {
        'cname': '上海',
        'pid': '',
        'pageIndex': pageNum,
        'pageSize': '10',
    }
    data = urllib.parse.urlencode(data).encode('utf-8')
    url = baseUrl
    return urllib.request.Request(url=url, data=data, headers=headers)


def get_content(request):
    return urllib.request.urlopen(request).read().decode('utf-8')


def download(pageNum, content):
    with open('resource/kfcStoreList' + str(pageNum) + '.json', 'w', encoding='utf-8') as f:
        f.write(content)


if __name__ == '__main__':
    for pageNum in range(1, 11):
        request = create_request(pageNum)
        content = get_content(request)
        download(pageNum, content)
