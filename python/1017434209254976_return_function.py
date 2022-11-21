# -*- coding: utf-8 -*-

# 返回函数

# def lazy_sum(*args):
#     def sum():
#         ax = 0
#         for n in args:
#             ax += n
#         return ax
#
#     return sum
#
#
# f = lazy_sum(1, 2, 3, 4, 5)
# f2 = lazy_sum(1, 2, 3, 4, 5)
#
# print(f == f2)
# print(f)

# print(f())

# def count():
#     fs = []
#     for i in range(1, 4):
#         def f():
#             return i ** 2
#
#         fs.append(f)
#     return fs

def count():
    def f(j):
        # def g():
        #     return j ** 2
        #
        # return g
        return lambda: j ** 2


#
#     fs = []
#     for i in range(1, 4):
#         fs.append(f(i))  # f(i)立刻被执行，因此i的当前值被传入f()
#     return fs
#
#
# f1, f2, f3 = count()
#
# print(f1())
# print(f2())
# print(f3())


# def inc():
#     x = 0
#
#     def fn():
#         # 仅读取x的值:
#         return x + 1
#
#     return fn

# def inc():
#     x = 0
#
#     def fn():
#         nonlocal x
#         x = x + 1
#         return x
#
#     return fn
#
#
# f = inc()
# print(f())
# print(f())


# test 1
# 利用闭包返回一个计数器函数，每次调用它返回递增整数：

def createCounter():
    sum = 0

    def counter():
        nonlocal sum
        sum += 1
        return sum

    return counter


# 测试:
counterA = createCounter()
print(counterA(), counterA(), counterA(), counterA(), counterA())  # 1 2 3 4 5
counterB = createCounter()
if [counterB(), counterB(), counterB(), counterB()] == [1, 2, 3, 4]:
    print('测试通过!')
else:
    print('测试失败!')
