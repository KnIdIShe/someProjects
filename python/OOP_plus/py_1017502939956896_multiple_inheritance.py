#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# 多重继承

class Animal(object):
    pass


# 大类
class Mammal(Animal):
    pass


class Bird(Animal):
    pass


class RunnableMaxIn(object):
    def run(self):
        print('Running...')


class FlyableMaxIn(object):
    def run(self):
        print('Flying...')


# 各种动物
class Dog(Mammal, RunnableMaxIn):
    pass


class Bat(Mammal, FlyableMaxIn):
    pass


class Parrot(Bird):
    pass


class Ostrich(Bird):
    pass


Dog().run()
