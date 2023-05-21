package cz.ahraban.mortgage.util;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
public enum ApplicationError {

    E01("No customer found for id: "),
    E02("No customer id specified"),
    E03("No subscription found for id: "),
    E04("No subscription id specified"),
    E05("No quotation found for id: "),
    E06("No quotation id specified ");

    private final String errorMessage;

    ApplicationError(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return this.errorMessage;
    }
}
