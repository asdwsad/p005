insert into entry(title,content,image,createdate,type) values('abc','asdsadasd','asd','2017-06-12','full')
insert into entry(title,content,image,createdate,type) values('abc','asdsadasd','asd','2018-06-12','onlytext')
insert into entry(title,content,image,createdate,type) values('abc','asdsadasd','asd','2019-06-12','onlyimage')
insert into entry(title,content,image,createdate,type) values('abc','asdsadasd','asd','2020-06-12','full')
insert into entry(title,content,image,createdate,type) values('abc','asdsadasd','asd','2021-06-12','onlytext')
insert into entry(title,content,image,createdate,type) values('abc','asdsadasd','asd','2022-06-12','onlytext')
insert into entry(title,content,image,createdate,type) values('abc','asdsadasd','asd','2023-06-12','full')


create proc paging

@rowperpage int,
@pagenum int
as 

begin

SELECT * FROM  
(SELECT *, ROW_NUMBER() OVER (ORDER BY createdate) as RowNum FROM entry ) as tbl
where tbl.RowNum between (@pagenum-1)*@rowperpage+1 and @pagenum*@rowperpage
end


exec paging @rowperpage=2 ,@pagenum=1