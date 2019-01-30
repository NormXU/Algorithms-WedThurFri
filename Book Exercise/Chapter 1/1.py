# 创建包含0-1000 x n-1的整数值

def test(n):
    return [i for i in range(n*1000)]

def test2(n):
    return list(range(n*1000))

内存一个单元可以保存一个字节的数据，一个字节是8位的2进制数据。 因此存放一个整数或者浮点数，需要
连续的几个单元； 浮点数需要8个字节

64位计算机一次可以存取8个字节的数据，也就是每次操作可以访问8个单元的内容 O(1)

Python的类
class Rational(object):
    def __init__(self, num, den=1):
        self.num = num
        self.den = den

    def __add__(self, another):
        den = self.den * another.den
        num = self.num * another.den + another.num * self.den
        return Rational(num, den)

    def __str__(self):
        return str(self._num) + "/" + str(self._den)

    @staticmethod
    def _gcd(m, n):
        if n == 0:
            m, n = n, m
        while m != 0:
            m, n = n%m, m

        return n

# 调用
r1 = r2.plus(Rational(3,5))

@staticmethod
是静态方法，其参数表中不应该有self

def __add__(arg):
其目的是重新定义新的算数运算符

def __str__(self)
把该类的对象转化为字符串
