# 시간초과 때문에 dfs대신 dp
# 메모이제이션 이용

def solution(triangle):
    answer = []
    memoiz = [[0 for j in range(len(triangle[i]))] for i in range(len(triangle))]
    memoiz[0][0] = triangle[0][0]
    for i in range(len(triangle)):
        if i == len(triangle)-1:
            break
        for j in range(len(triangle[i])):
            if j == 0:
                memoiz[i+1][j] = (memoiz[i][j] + triangle[i+1][j])
                memoiz[i+1][j+1] = (memoiz[i][j] + triangle[i+1][j+1])
            elif j == len(triangle[i]) -1:
                memoiz[i+1][j+1] = memoiz[i][j] + triangle[i+1][j+1]
                if memoiz[i+1][j] < memoiz[i][j] + triangle[i+1][j]:
                    memoiz[i+1][j] = memoiz[i][j] + triangle[i+1][j]
            else:
                 if memoiz[i+1][j] < memoiz[i][j] + triangle[i+1][j]:
                    memoiz[i+1][j] = memoiz[i][j] + triangle[i+1][j]
                    
                 memoiz[i+1][j+1] = memoiz[i][j] + triangle[i+1][j+1]
                

    answer = max(memoiz[len(memoiz)-1])
    return answer



# dfs 시간초과

# def solution(triangle):
#     answer = []
#     def dfs(sumNum, idx, dir, triangle):
#         if idx == len(triangle):
#             answer.append(sumNum)
#             return
#         if 0 <= dir < len(triangle[idx]):
#             sumNum+=triangle[idx][dir]
#             dfs(sumNum, idx+1, dir, triangle)
#             dfs(sumNum, idx+1, dir+1, triangle)
#         return
#     dfs(0, 0, 0,triangle)
#     return max(answer)