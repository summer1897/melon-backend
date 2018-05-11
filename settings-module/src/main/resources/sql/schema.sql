USE melon;

DROP TABLE IF EXISTS user;

#用户信息表
CREATE TABLE user (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '唯一标识ID',
  user_name VARCHAR(300) NOT NULL COMMENT '用户名',
  nick_name VARCHAR(300) COMMENT '昵称',
  password VARCHAR(300) NOT NULL COMMENT '密码',
  salt VARCHAR(300) NOT NULL COMMENT '密码加密盐',
  sex SMALLINT NOT NULL DEFAULT 0 COMMENT '性别，默认为0,0表示男，1表示女',
  marital_status SMALLINT NOT NULL DEFAULT 0 COMMENT '婚姻状况,0表示已婚，1表示未婚',
  political_status INT NOT NULL DEFAULT 0 COMMENT '政治面貌，默认0，表示群众',
  nation VARCHAR(30) DEFAULT '汉族' COMMENT '民族',
  degree_of_education int DEFAULT 0
    COMMENT '文化程度，0表示无，1表示小学，2表示初中，3表示高中，4表示本科，5表示中专，6表示大专，7表示硕士研究生，8表示博士',
  academic_degree int DEFAULT 0 COMMENT '学位，0表示无，1表示小学，2表示初中，3表示高中，4表示学士，5表示中专，6表示大专，7表示硕士，8表示博士',
  graduate_institutions VARCHAR(30) COMMENT '毕业院校',
  major VARCHAR(30) COMMENT '所学专业',
  year_of_major SMALLINT COMMENT '专业学制',
  post VARCHAR(30) COMMENT '职务',
  title VARCHAR(30) COMMENT '职称',
  phone VARCHAR(20) COMMENT '手机号码',
  email VARCHAR(50) COMMENT '邮箱',
  locked SMALLINT NOT NULL DEFAULT 1 COMMENT '用户状态，1表示正常，其他表示禁用',
  photo VARCHAR(300) COMMENT '头像存放路径',
  residence_address VARCHAR(500) COMMENT '户籍地址',
  current_address VARCHAR(500) COMMENT '当前所在地',
  birthday DATETIME NOT NULL DEFAULT now() COMMENT '出生日期',
  time_of_entry DATETIME NOT NULL DEFAULT now() COMMENT '参加工作时间',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '信息修改日期',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '信息创建日期',
  PRIMARY KEY(id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS family_relationship;

CREATE TABLE family_relationship (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id',
  user_id BIGINT NOT NULL COMMENT '用户Id',
  relationship VARCHAR(30) COMMENT '与当事人关系',
  name VARCHAR(50) COMMENT '姓名',
  age INT COMMENT '年龄',
  degree_of_education SMALLINT DEFAULT 0 COMMENT '文化程度',
  jpb VARCHAR(30) COMMENT '工作',
  phone VARCHAR(30) COMMENT '联系方式',
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

#用户角色表
DROP TABLE IF EXISTS role;

CREATE TABLE role (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '角色唯一标识ID',
  name VARCHAR(200) NOT NULL COMMENT '角色名称',
  description VARCHAR(300) COMMENT '角色描述',
  available SMALLINT DEFAULT 0 COMMENT '是否可用，0:表示不可用，1:表示可用',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  PRIMARY KEY (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#权限表
DROP TABLE IF EXISTS permission;
CREATE TABLE permission (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '资源唯一标识ID',
  parent_id BIGINT COMMENT '父级菜单Id',
  parent_ids VARCHAR(300) COMMENT '父级编号列表',
  name VARCHAR(200) NOT NULL COMMENT '资源名称',
  icon VARCHAR(100) DEFAULT '' COMMENT '图标',
  type INT COMMENT '资源类型，1表示菜单(menu)，2表示连接地址(url)，3表示按钮(button)',
  url VARCHAR(300) COMMENT '资源路径',
  permission VARCHAR(500) COMMENT '权限字符串,如,user,role:*,按钮,button:create..',
  available SMALLINT DEFAULT 1 COMMENT '是否可用,默认为1,0:禁用，1:表示可用',
  sort INT DEFAULT 1 COMMENT '权限资源排序',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  PRIMARY KEY (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#用户、角色关联表
DROP TABLE IF EXISTS user_role;

CREATE TABLE user_role (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '唯一标识ID',
  user_id BIGINT NOT NULL COMMENT '用户唯一标识ID',
  role_id BIGINT NOT NULL COMMENT '角色唯一标识ID',
  description VARCHAR(500) COMMENT '描述',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  PRIMARY KEY (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#角色、权限关联表
DROP TABLE IF EXISTS role_permission;

CREATE TABLE role_permission (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '唯一标识ID',
  role_id BIGINT NOT NULL COMMENT '角色唯一标识ID',
  permission_id BIGINT NOT NULL COMMENT '权限唯一标识ID',
  description VARCHAR(500) COMMENT '描述',
  create_date DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  PRIMARY KEY (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;


