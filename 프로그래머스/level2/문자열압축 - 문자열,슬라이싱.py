def solution(s):
    answer = 0
    result = []
    if len(s) == 1:
        result = [1]
    else:
        for i in range(1, (len(s)//2)+1):
            res = ''
            cnt = 1
            temp = s[0:i]
            for j in range(i, len(s)+i, i):
                if temp == s[j:j+i]:
                    cnt+=1
                else:
                    if cnt == 1:
                        res = res + temp
                        temp = s[j:j+i]
                    else:
                        res = res + str(cnt) + temp
                        temp = s[j:j+i]
                        cnt =1
            result.append(len(res))
    answer = min(result)    
    return answer