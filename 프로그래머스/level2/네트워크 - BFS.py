from collections import *

# 이문제는 그래프의 깊이나 가중치를 알필요없어서 DFS나 BFS아무거나 써도됨
# 양방향 그래프..?

def solution(n, computers):
    answer = 0
    visited = n * [False]
    for i in range(n):
        if not visited[i]:
            answer+=1
            bfs(i, visited, n, computers)
    
    return answer

def bfs(start, visited, n, computers):
    queue = deque()
    queue.append(start)
    visited[start] = True
    while queue:
        idx = queue.popleft()
        for i in range(n):
            if computers[idx][i] == 1 and visited[i] == False:
                visited[i] = True
                queue.append(i)