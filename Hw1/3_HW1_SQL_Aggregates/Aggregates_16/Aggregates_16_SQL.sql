select row_number() over (order by joindate) as row_number, firstname, surname
from cd.members
order by joindate;