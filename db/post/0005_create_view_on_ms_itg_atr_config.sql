 Declare 
    l_Error_Code   Number;
    l_Error_Msg    Varchar2(2000);
Begin 
    Ms_Apps_Utilities.Create_Infolet_View('INFOLET','MS_ITG_ATR_CONFIG','MS_ITG_ATR_CONFIG_V', l_Error_Code, l_Error_Msg);
    Dbms_Output.Put_Line('l_Error_Code:'||l_Error_Code||' l_Error_Msg:'|| l_Error_Msg);
    Commit;

End;
