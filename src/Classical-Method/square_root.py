# 牛顿迭代法

def sqrt(x):
    y = 1.0
    while (y*y - x) > 1e-6:
        y = (y + x/y) / 2
    return y
