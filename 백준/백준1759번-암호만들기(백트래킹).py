import sys

l, c = map(int, input().split())
alpha = input().split()
alpha.sort()
s = []
vowels = set(['a', 'e', 'i', 'o', 'u'])

def main(idx):
    if len(s) == l:
        if len(set(s) & vowels) > 0 and len(set(s) - vowels) > 1:
            print(''.join(map(str, s)))
            return
    for i in range(idx, c):
        if i in s:
            continue
        s.append(alpha[i])
        main(i+1)
        s.pop()
main(0)