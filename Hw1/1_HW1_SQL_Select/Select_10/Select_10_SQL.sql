select surname as surname
from cd.members
union
select name as surname
from cd.facilities