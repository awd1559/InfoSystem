create table is_coding (
  id                            bigint auto_increment not null,
  category                      varchar(255) not null,
  subcategory                   varchar(255) not null,
  tag                           varchar(255) not null,
  description                   varchar(255) not null,
  language                      varchar(255),
  author                        varchar(255),
  homelink                      varchar(255),
  doclink                       varchar(255),
  sourcelink                    varchar(255),
  os_last_update                bigint,
  os_rank_count                 float,
  os_fav_count                  integer,
  os_comment_count              integer,
  git_star                      integer,
  git_fork                      integer,
  git_last_update               bigint,
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_updated                  datetime(6) not null,
  constraint pk_is_coding primary key (id)
);

create table is_company (
  id                            bigint auto_increment not null,
  line                          varchar(255) not null,
  name                          varchar(255) not null,
  manager                       varchar(255) not null,
  phone                         varchar(255),
  address                       varchar(255),
  site                          varchar(255),
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_updated                  datetime(6) not null,
  constraint pk_is_company primary key (id)
);

create table is_note (
  id                            bigint auto_increment not null,
  title                         varchar(255) not null,
  body                          varchar(255) not null,
  tag                           varchar(255),
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_updated                  datetime(6) not null,
  constraint pk_is_note primary key (id)
);

create table is_software (
  id                            bigint auto_increment not null,
  category                      varchar(255) not null,
  platform                      varchar(255),
  name                          varchar(255) not null,
  description                   varchar(255),
  tag                           varchar(255),
  homelink                      varchar(255),
  oslink                        varchar(255),
  author                        varchar(255),
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_updated                  datetime(6) not null,
  constraint pk_is_software primary key (id)
);

create table is_study (
  id                            bigint auto_increment not null,
  category_id                   bigint,
  title                         varchar(255) not null,
  description                   varchar(255),
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_updated                  datetime(6) not null,
  constraint pk_is_study primary key (id)
);

create table is_studycategory (
  id                            bigint auto_increment not null,
  subject                       varchar(255) not null,
  version                       bigint not null,
  when_created                  datetime(6) not null,
  when_updated                  datetime(6) not null,
  constraint pk_is_studycategory primary key (id)
);

alter table is_study add constraint fk_is_study_category_id foreign key (category_id) references is_studycategory (id) on delete restrict on update restrict;
create index ix_is_study_category_id on is_study (category_id);

