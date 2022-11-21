#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/17 20:35

# 解析 json 数据

import json
import jsonpath

obj = json.load(open('073_parse_jsonpath.json', 'r', encoding='utf-8'))

# 所有书的作者
# authors = jsonpath.jsonpath(obj, '$.store.book[*].author')
# print(authors)

# 所有的作者
# authors = jsonpath.jsonpath(obj, '$..author')
# print(authors)

# store 下所有的元素
# stores = jsonpath.jsonpath(obj, '$.store.*')
# print(stores)

# store 下所有的 price
# prices = jsonpath.jsonpath(obj, '$.store..price')
# print(prices)

# 第三本书
# book = jsonpath.jsonpath(obj, '$..book[2]')
# print(book)

# 最后一本书
# book = jsonpath.jsonpath(obj, '$..book[(@.length-1)]')
# print(book)

# 前两本书
# books = jsonpath.jsonpath(obj, '$..book[0,1]')
# books = jsonpath.jsonpath(obj, '$..book[:2]')
# print(books)

# 包含 isbn 的书
# books = jsonpath.jsonpath(obj, '$..book[?(@.isbn)]')
# print(books)

# price > 10
books = jsonpath.jsonpath(obj, '$..book[?(@.price>10)]')
print(books)
