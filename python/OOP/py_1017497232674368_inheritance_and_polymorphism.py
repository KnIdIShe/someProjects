#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# 继承和多态

class Animal(object):
    def run(self):
        print('Animal is running...')


class Dog(Animal):
    def run(self):
        print('Dog is running...')

    def eat(self):
        print('Eating meat...')


class Cat(Animal):
    def run(self):
        print('Cat is running...')


class Tortoise(Animal):
    def run(self):
        print('Tortoise is running slowly...')


class Timer(Animal):
    def run(self):
        print('Start...')


def run_twice(animal):
    animal.run()
    animal.run()


# dog = Dog()
# dog.run()
#
# cat = Cat()
# cat.run()

# run_twice(Tortoise())
run_twice(Timer())
