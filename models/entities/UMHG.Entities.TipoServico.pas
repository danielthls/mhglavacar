unit UMHG.Entities.TipoServico;

interface

type
  TTipoServico = class
    private
      FId: Integer;
      FNome: String;
      FDescricao: String;
      FCriadoEm: TDateTime;
      FCriadoPor: Integer;
      FModificadoEm: TDateTime;
      FModificadoPor: Integer;
    function GetCriadoEm: TDateTime;
    function GetCriadoPor: Integer;
    function GetDescricao: String;
    function GetId: Integer;
    function GetModificadoEm: TDateTime;
    function GetModificadoPor: Integer;
    function GetNome: String;
    procedure SetCriadoEm(const Value: TDateTime);
    procedure SetCriadoPor(const Value: Integer);
    procedure SetDescricao(const Value: String);
    procedure SetId(const Value: Integer);
    procedure SetModificadoEm(const Value: TDateTime);
    procedure SetNome(const Value: String);
    procedure SetModificadoPor(const Value: Integer);
    public
      property Id: Integer read GetId write SetId;
      property Nome: String read GetNome write SetNome;
      property Descricao: String read GetDescricao write SetDescricao;
      property CriadoEm: TDateTime read GetCriadoEm write SetCriadoEm;
      property CriadoPor: Integer read GetCriadoPor write SetCriadoPor;
      property ModificadoEm: TDateTime read GetModificadoEm write SetModificadoEm;
      property ModificadoPor: Integer read GetModificadoPor write SetModificadoPor;
  end;

implementation

{ TTipoServico }

function TTipoServico.GetCriadoEm: TDateTime;
begin
  Result := FCriadoEm;
end;

function TTipoServico.GetCriadoPor: Integer;
begin
  Result := FCriadoPor;
end;

function TTipoServico.GetDescricao: String;
begin
  Result := FDescricao;
end;

function TTipoServico.GetId: Integer;
begin
  Result := FId;
end;

function TTipoServico.GetModificadoEm: TDateTime;
begin
  Result := FModificadoEm;
end;

function TTipoServico.GetModificadoPor: Integer;
begin
  Result := FModificadoPor;
end;

function TTipoServico.GetNome: String;
begin
  Result := FNome;
end;

procedure TTipoServico.SetCriadoEm(const Value: TDateTime);
begin
  FCriadoEm := Value;
end;

procedure TTipoServico.SetCriadoPor(const Value: Integer);
begin
  FCriadoPor := Value;
end;

procedure TTipoServico.SetDescricao(const Value: String);
begin
  FDescricao := Value;
end;

procedure TTipoServico.SetId(const Value: Integer);
begin
  FId := Value;
end;

procedure TTipoServico.SetModificadoEm(const Value: TDateTime);
begin
  FModificadoEm := Value;
end;

procedure TTipoServico.SetModificadoPor(const Value: Integer);
begin
  FModificadoPor := Value;
end;

procedure TTipoServico.SetNome(const Value: String);
begin
  FNome := Value;
end;

end.
