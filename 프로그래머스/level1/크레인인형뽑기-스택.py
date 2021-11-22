from collections import deque

def solution(board, moves):
    answer = 0
    dq = [0]  # 0은 list index out of range 방지
    for i in range(len(moves)):
        for j in range(len(board)):
            if board[j][moves[i]-1] != 0:
                if dq[-1] == board[j][moves[i]-1]:
                    board[j][moves[i]-1] = 0
                    dq.pop()
                    answer += 2
                else:
                    dq.append(board[j][moves[i]-1])
                    board[j][moves[i]-1] = 0
                break

    return answer