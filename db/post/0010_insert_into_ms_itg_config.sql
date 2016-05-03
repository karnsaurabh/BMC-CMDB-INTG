begin
Delete from MS_ITG_CONFIG where config_key like '%atr%';
Delete from MS_ITG_CONFIG where config_key like 'atr%';
Insert into MS_ITG_CONFIG (CONFIG_KEY,CONFIG_VALUE) values ('ms.atr.last.run',null);
Insert into MS_ITG_CONFIG (CONFIG_KEY,CONFIG_VALUE) values ('atr.server.url',null);
Insert into MS_ITG_CONFIG (CONFIG_KEY,CONFIG_VALUE) values ('atr.server.user.name',null);
Insert into MS_ITG_CONFIG (CONFIG_KEY,CONFIG_VALUE) values ('atr.server.user.password',null);

commit;
end;