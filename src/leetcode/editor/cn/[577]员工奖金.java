# Write your MySQL query statement below

        select A.name,sum(B.bonus)as bonus from Employee A
        left join Bonus B
        on A.empId=b.empId
        group by A.empId
        having sum(B.bonus)<1000or sum(B.bonus)is null;