# -*- coding: utf-8 -*-

# 在一个list中，删掉偶数，只保留奇数
# def is_odd(n):
#     return n % 2 == 1
#
#
# print(list(filter(is_odd, [1, 2, 3, 4, 5, 6])))


# 把一个序列中的空字符串删掉
# def not_empty(s):
#     return s and s.strip()
#
#
# print(list(filter(not_empty, ['A', '', 'B', None, 'C', ' '])))


# 计算素数的一个方法是埃氏筛法

# 从3开始的奇数序列：
# def _odd_iter():
#     n = 1
#     while True:
#         n += 2
#         yield n
#
#
# # 筛选函数：
# def _not_divisible(n):
#     return lambda x: x % n > 0
#
#
# # 定义一个生成器，不断返回下一个素数：
# def primes():
#     yield 2
#     it = _odd_iter()  # 初始序列
#     while True:
#         n = next(it)  # 返回序列的第一个值
#         yield n
#         it = filter(_not_divisible(n), it)
#
#
# # 由于primes()也是一个无限序列，所以调用时需要设置一个退出循环的条件：
# # 打印1000以内的素数:
# for n in primes():
#     if n < 100:
#         print(n)
#     else:
#         break


# test 1
# 回数是指从左向右读和从右向左读都是一样的数，例如12321，909。请利用filter()筛选出回数：

def is_palindrome(n):
    # type 1
    # s = str(n)
    # return s == s[::-1]

    # type 2, 首尾相比, 比较 floor(len/2) 次

    s = str(n)
    l = len(s)

    if l == 1:
        return True

    # 比较次数, 向下取整
    c = int(l / 2)
    # or import math math.floor()
    for i in range(c):
        if s[i] != s[l - 1 - i]:
            return False
    return True


# 测试:
output = filter(is_palindrome, range(1, 1000))
print('1~1000:', list(output))
if list(filter(is_palindrome, range(1, 200))) == [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99, 101,
                                                  111, 121, 131, 141, 151, 161, 171, 181, 191]:
    print('测试成功!')
else:
    print('测试失败!')
