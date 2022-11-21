#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/17 20:35

# bs4 解析本地文件

from bs4 import BeautifulSoup

soup = BeautifulSoup(open('075_parse_bs4_basic.html', encoding='utf-8'), 'lxml')
# 根基标签名查找, 按先后顺序
# print(soup.a)
# 标签属性和属性值
# print(soup.a.attrs)

# 常用函数
# 第一个符合条件的数据
# print(soup.find('a'))
# 符合其他条件
# print(soup.find('a', title="a2"))
# class属性需加下划线避开python自带关键字
# print(soup.find('a', class_="c2"))

# 所有
# print(soup.find_all('a'))

# 所有 a, 或 span
# print(soup.find_all(['a', 'span']))

# 前几个数据
# print(soup.find_all('li', limit=2))

# 标签element选择器
# print(soup.select('a'))

# class选择器
# print(soup.select('.c2'))

# id选择器
# print(soup.select('#i1'))

# 属性选择器
# print(soup.select('li[id]'))

# 属性为i2
# print(soup.select('li[id="i2"]'))

# 层级选择器
# 后代选择器
# print(soup.select('div li'))

# 子代选择器
# print(soup.select('div > ul > li'))

# or 选择器
# print(soup.select('a, li'))

# 获取节点内容
# obj = soup.select('#d2')[0]
# 单层
# print(obj.string)
# 多层
# print(obj.get_text())

# 节点名
obj = soup.select('#p1')[0]
# print(obj.name)
# 属性值, 字典
# print(obj.attrs)
# 具体某个属性
print(obj.attrs.get('class'))
print(obj.get('class'))
print(obj['class'])