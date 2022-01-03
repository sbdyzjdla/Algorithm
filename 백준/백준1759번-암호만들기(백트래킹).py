import sys

l, c = map(int, input().split())
alpha = input().split()
alpha.sort()
s = []
mo = ['a', 'e', 'i', 'o', 'u']
def main(idx):
    if len(s) == l:
        print(''.join(map(str, s)))
        return
    for i in range(idx, c):
        if i in s:
            continue
        s.append(alpha[i])
        main(i+1)
        s.pop()
main(0)