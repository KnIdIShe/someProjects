# -*- coding: utf-8 -*-

# test 1
# 利用map()函数，把用户输入的不规范的英文名字，变为首字母大写，其他小写的规范名字。输入：['adam', 'LISA', 'barT']，输出：['Adam', 'Lisa', 'Bart']：

# from functools import reduce
#
#
# def normalize(name):
#     # return name[0].upper() + reduce(lambda x, y: x + y, map(lambda s: s.lower(), name))[1:]
#
#     # capitalize()
#     # 将字符串的第一个字符转换为大写
#     # return reduce(lambda x, y: x + y, map(lambda s: s.lower(), name)).capitalize()
#
#     # title()
#     # 返回"标题化"的字符串,就是说所有单词都是以大写开始，其余字母均为小写(见 istitle())
#     return name.title()
#
#
# # 测试:
# L1 = ['adam', 'LISA', 'barT']
# L2 = list(map(normalize, L1))
# print(L2)


# test 2
# Python提供的sum()函数可以接受一个list并求和，请编写一个prod()函数，可以接受一个list并利用reduce()求积：

# from functools import reduce
#
#
# def prod(L):
#     return reduce(lambda x, y: x * y, L)
#
#
# print('3 * 5 * 7 * 9 =', prod([3, 5, 7, 9]))
# if prod([3, 5, 7, 9]) == 945:
#     print('测试成功!')
# else:
#     print('测试失败!')


# test 3
# 利用map和reduce编写一个str2float函数，把字符串'123.456'转换成浮点数123.456：

from functools import reduce


def str2float(s):
    # 确认小数点左移几位
    index = len(s) - (s.find('.') + 1)
    sNew = s.replace('.', '', 1)
    return reduce(lambda x, y: x * 10 + y, map(int, sNew)) / (10 ** index)

    # return int(l[0]) + int(l[1]) / (10 ** len(l[1]))
    # return float(s)


print('str2float(\'123.456\') =', str2float('123.456'))
if abs(str2float('123.456') - 123.456) < 0.00001:
    print('测试成功!')
else:
    print('测试失败!')
