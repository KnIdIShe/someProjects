#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# @Author: amihso
# @Time  : 2022/04/13 19:36

import urllib.request

# 下载网页
# url_page = 'http://www.baidu.com'
# urllib.request.urlretrieve(url_page, 'baidu.html')

# 下载图片
# url_img = 'https://img0.baidu.com/it/u=1023354135,3388725821&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=704'
# urllib.request.urlretrieve(url=url_img, filename='lisa.jpg')

# 下载视频
url_video = 'https://vd2.bdstatic.com/mda-mgbd42awzrh1wya2/sc/cae_h264/1626081633715636071/mda-mgbd42awzrh1wya2.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1649852606-0-0-9947c65c3371a7df9ff69be3747a05f8&bcevod_channel=searchbox_feed&pd=1&cd=0&pt=3&logid=3206328270&vid=12418851779246672200&abtest=100815_1-101454_3-17451_1&klogid=3206328270'
urllib.request.urlretrieve(url_video, 'lisa.mp4')
