CREATE TABLE IF NOT EXISTS cd.members
(
    memid               integer                        NOT NULL,
    surname             character varying(200)         NOT NULL,
    firstname           character varying(200)         NOT NULL,
    address             character varying(300)         NOT NULL,
    zipcode             integer NOT NULL,
    telephone           character varying(20)          NOT NULL,
    recommendedby       integer,
    joindate            timestamp                      NOT NULL,

    CONSTRAINT members_pk PRIMARY KEY (memid),
    CONSTRAINT fk_members_recommendedby FOREIGN KEY (recommendedby) REFERENCES cd.members(memid) ON DELETE SET NULL
);

CREATE INDEX IF NOT EXISTS "members.joindate" ON cd.members USING btree (joindate);
CREATE INDEX IF NOT EXISTS "members.recommendedby" ON cd.members USING btree (recommendedby);

CREATE TABLE IF NOT EXISTS cd.facilities
(
    facid               integer                        NOT NULL,
    name                character varying(100)         NOT NULL,
    membercost          numeric                        NOT NULL,
    guestcost           numeric                        NOT NULL,
    initialoutlay       numeric                        NOT NULL,
    monthlymaintenance  numeric                        NOT NULL,

    CONSTRAINT facilities_pk PRIMARY KEY (facid)
);

CREATE TABLE IF NOT EXISTS cd.bookings
(
    bookid              integer                        NOT NULL,
    facid               integer                        NOT NULL,
    memid               integer                        NOT NULL,
    starttime           timestamp                      NOT NULL,
    slots               integer                        NOT NULL,

    CONSTRAINT bookings_pk       PRIMARY KEY (bookid),
    CONSTRAINT fk_bookings_facid FOREIGN KEY (facid) REFERENCES cd.facilities(facid),
    CONSTRAINT fk_bookings_memid FOREIGN KEY (memid) REFERENCES cd.members(memid)
);

CREATE INDEX IF NOT EXISTS "bookings.memid_facid" ON cd.bookings USING btree (memid, facid);
CREATE INDEX IF NOT EXISTS "bookings.facid_memid" ON cd.bookings USING btree (facid, memid);
CREATE INDEX IF NOT EXISTS "bookings.facid_starttime" ON cd.bookings USING btree (facid, starttime);
CREATE INDEX IF NOT EXISTS "bookings.memid_starttime" ON cd.bookings USING btree (memid, starttime);
CREATE INDEX IF NOT EXISTS "bookings.starttime" ON cd.bookings USING btree (starttime);