def solution(numbers, target):
    answer = []
    def dfs(numbers, target, idx, s=[]):
        if idx == len(numbers):
            if len(s) == len(numbers) and sum(s) == target:
                answer.append(1)
                return
            else:
                return
        
        curNum = numbers[idx]
        s.append(curNum)
        dfs(numbers, target, idx+1, s)
        s.pop()
        s.append((-1)*curNum)
        dfs(numbers, target, idx+1, s)
        s.pop()
        
    dfs(numbers, target, 0)
    
    return sum(answer)