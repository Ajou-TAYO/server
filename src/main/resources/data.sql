#INSERT INTO bus_stop(name,lat,lng) VALUES ('광교중앙역 1번 출구', 37.28792507165555, 127.05207080906703);
#INSERT INTO bus_stop(name,lat,lng) values ('수원역 9번/10번 출구', 37.266642681300176, 127.00170518816412);
#INSERT INTO bus_stop(name,lat,lng) values ('도서관 도로변', 37.2817913450616, 127.04346000090717);
#INSERT INTO bus_stop(name, lat, lng) values ('원천관 입구',37.28280161912451, 127.04350427780675);
#INSERT INTO bus_stop(name, lat, lng) values ('율곡관 도로변',37.28174406129355, 127.04637346772104 );


INSERT INTO bus_route(name,type,dep_bus_stop_id,mid_bus_stop_id,arr_bus_stop_id,department_time_list) VALUES ('광교중앙역', '등교',1,5,4,'08:30,08:50');
INSERT INTO bus_route(name,type,dep_bus_stop_id,mid_bus_stop_id,arr_bus_stop_id, department_time_list) VALUES ('광교중앙역', '등교',1,5,3,'09:30,10:00,10:15,11:45,16:00,17:00');
INSERT INTO bus_route(name,type,dep_bus_stop_id,mid_bus_stop_id,arr_bus_stop_id, department_time_list) values ('수원역', '등교',2,5,4,'08:20');
INSERT INTO bus_route(name,type,dep_bus_stop_id,arr_bus_stop_id, department_time_list) values ('수원역', '등교',2,3,'09:50,11:20');
INSERT INTO bus_route(name,type,dep_bus_stop_id,arr_bus_stop_id, department_time_list) values ('수원역','하교',3,2,'15:10,16:40');
INSERT INTO bus_route(name,type,dep_bus_stop_id,mid_bus_stop_id,arr_bus_stop_id, department_time_list) values ('수원역','하교',5,4,2,'18:10');
INSERT INTO bus_route(name, type,dep_bus_stop_id,arr_bus_stop_id, department_time_list) values ('광교중앙역','하교',3,1,'08:20,08:40,09:20,09:55,10:05,11:35,13:10,14:35,16:05,17:20');
INSERT INTO bus_route(name, type,dep_bus_stop_id,mid_bus_stop_id,arr_bus_stop_id, department_time_list) values ('광교중앙역','하교',5,4,1,'18:10');
