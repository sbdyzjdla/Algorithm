def solution(brown, yellow):
    answer = []
    arr = []
    total = brown+yellow
    for i in range(1, total+1):
         if (total) % i == 0:
            if (total) // i >= i:
                arr.append([(total) // i,i])

    for i in arr:
        x, y = i[0], i[1]
        if y == 1:
            if yellow == (x-2):
                answer = i
        elif y > 2:
            if (x -2) * (y -2) == yellow:
                answer = i
    return answer