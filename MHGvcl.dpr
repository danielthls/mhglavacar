program MHGvcl;

uses
  Vcl.Forms,
  UfrmTeste in 'UfrmTeste.pas' {Form1},
  UMHG.Utils.Banco in 'models\utils\UMHG.Utils.Banco.pas',
  UMHG.Entities.TipoServico in 'models\entities\UMHG.Entities.TipoServico.pas',
  UMHG.DAO.Intf in 'models\dao\UMHG.DAO.Intf.pas',
  UMHG.DAO.Base in 'models\dao\UMHG.DAO.Base.pas';

{$R *.res}

begin
  Application.Initialize;
  ReportMemoryLeaksOnShutdown := True;
  Application.MainFormOnTaskbar := True;
  Application.CreateForm(TForm1, Form1);
  Application.Run;
end.
