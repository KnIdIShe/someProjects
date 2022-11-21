# -*- coding: utf-8 -*-

# 偏函数

# 二进制 --> 十进制
# def int2(x, base=2):
#     return int(x, base)
#
#
# print(int2('0101'))

import functools

int2 = functools.partial(int, base=2)
print(int2('0101'))

max2 = functools.partial(max, 10)
print(max2(1, 3, 5))
